<template>
  <div>
    <ul>
      <li v-for="repo in repos"
        :key="repo.name"
        @click="fetch(repo.name)">
        <b>{{ repo.name }}</b>
      </li>
    </ul>
  </div>
</template>

<script>
import {mapState} from 'vuex'
export default {
  name: "repoList",
  async fetch() {
    await this.$store.dispatch("getRepos")
  },
  data() {
    return{
      repo: ''
    }
  },
  computed: {
    ...mapState(["repos"])
  },
  methods: {
    async fetch(repo){
      await this.$store.dispatch('getBranchList', repo)
      await this.$store.dispatch('getCommitCnt', repo)
      await this.$store.dispatch('getPrCnt', repo)
      await this.$store.dispatch('getUserCnt', repo)
      await this.$store.dispatch('getBranchCnt', repo)
      await this.$store.dispatch('getCommitCntByUser', repo)
      await this.$store.dispatch('getPrCntByUser', repo)
      this.$emit('update',repo)
    },
  }
};
</script>

<style lang="scss" scoped>

</style>

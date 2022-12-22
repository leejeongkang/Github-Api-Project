<template>
  <div>
    <ul>
      <li v-for="repo in repos"
        :key="repo.name"
        @click="showInform(repo.name)">
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
    await this.$store.dispatch('getRepos')
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
    async showInform(repo){
      /*const result = await Promise.all([
        'getCommitCnt', 'getPrCnt', 'getUserCnt', 'getBranchCnt',
          'getCommitCntByUser', 'getPrCntByUser', 'getBranchList'
      ].map(repo))*/
      this.$emit('update',repo)
      await this.$store.dispatch('getBranchList', repo)
    },
  }
};
</script>

<style lang="scss" scoped>

</style>

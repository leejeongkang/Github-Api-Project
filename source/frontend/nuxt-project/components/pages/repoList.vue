<template>
  <div>
    <h1>repository</h1>
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
import {mapActions, mapState} from 'vuex'
export default {
  name: "repoList",
  data() {
    return{
      repo: ''
    }
  },
  computed: {
    ...mapState({
      repos: state => state.repos
    })
  },
  methods: {
    ...mapActions(['getRepos']),
    showInform(repo){
      this.$emit('update',repo)
      return Promise.all([
        this.$store.dispatch('getBranchList', repo),
        this.$store.dispatch('getCommitCnt', repo),
        this.$store.dispatch('getBranchCnt', repo),
        this.$store.dispatch('getUserCnt', repo),
        this.$store.dispatch('getPrCnt', repo),
      ])
    },
  }
};
</script>

<style lang="scss" scoped>

</style>

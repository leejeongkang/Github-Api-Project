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
    ...mapActions({getRepos: 'getRepos'}),
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

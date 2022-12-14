<template>
  <div>
    <ul>
      <li v-for="repo in $store.state.repos" :key="repo.name" @click="fetch(repo.name)">
        <b>{{ repo.name }}</b>
      </li>
    </ul>
    <ul>
      <li v-for="branch in $store.state.branchList" :key="branch.name">
        {{ branch.name }}
      </li>
    </ul>
  </div>
</template>


<script>
import {
  FETCH_BRANCH_LIST,
  FETCH_REPOS
} from "@/store";
import DetailCount from "@component/pages/detailCount";

export default {
  name: "Index",
  components: {DetailCount},
  async asyncData({ store }) {
    await store.dispatch(FETCH_REPOS)
  },
  methods: {
    async fetch(repo){
      console.log(repo)
      await this.$store.dispatch(FETCH_BRANCH_LIST, repo)
    }
  }
};
</script>

<style lang="scss" scoped>

</style>

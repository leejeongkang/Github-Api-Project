<template>
  <div>
    <ul>
      <li v-for="repo in $store.state.repos">
        {{ repo.name }}
      </li>
    </ul>
  </div>
</template>


<script>
import { FETCH_REPOS } from '@/store'
export default {
  name: "Index",

  async asyncData({ store }) {
    await store.dispatch(FETCH_REPOS);
  },
};
</script>

<style lang="scss" scoped>

</style>

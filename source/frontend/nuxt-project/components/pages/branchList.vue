<template>
  <div>
    <h3>branch list component</h3>
    <p> {{ repo }}</p>
    <ul>
      <li v-for="branch in $store.state.branchList"
          :key="branch.name">
        {{ branch.name }}
      </li>
    </ul>
  </div>
</template>

<script>

export default {
  name: "BranchList",
  props: {
    repo: {
      type: String,
      required: true
    }
  },
};
</script>

<style lang="scss" scoped>

</style>

<template>
  <div>
    <h3>branch list component</h3>
    <p> {{ repo }}</p>
    <ul>
      <li v-for="branch in branchList"
          :key="branch.name">
        {{ branch.name }}
      </li>
    </ul>
  </div>
</template>

<script>

import {mapActions, mapState} from "vuex";

export default {
  name: "BranchList",
  props: {
    repo: {
      type: String,
      required: true
    }
  },
  computed: {
    ...mapState(['branchList'])
  }
};
</script>

<style lang="scss" scoped>

</style>

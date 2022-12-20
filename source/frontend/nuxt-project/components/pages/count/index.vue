<template>
  <div>
    <h2>Commit, Author, Branches, PullRequest Count</h2>
    <p>commit {{ commitCnt }}</p>
    <p>pr {{ prCnt }}</p>
    <p>author {{ authorCnt }}</p>
    <p>branch {{ branchCnt }}</p>
    <p>props : {{ repo }}</p>
  </div>
</template>

<script>

import {mapState} from "vuex";

export default {
  name: "detailCount",
  props: {
    repo: {
      type: String
    }
  },
  computed: {
    ...mapState(['commitCnt', 'prCnt', 'authorCnt', 'branchCnt'])
  }
}
</script>

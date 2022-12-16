<template>
  <div>
    <h2>Commit, Author, Branches, PullRequest Count</h2>
    <p>commit {{ $store.state.commitCnt }}</p>
    <p>pr {{ $store.state.prCnt }}</p>
    <p>author {{ $store.state.authorCnt }}</p>
    <p>branch {{ $store.state.branchCnt }}</p>
    <p>props : {{ repo }}</p>
  </div>
</template>

<script>

export default {
  name: "detailCount",
  props: {
    repo: {
      type: String
    }
  },
}
</script>

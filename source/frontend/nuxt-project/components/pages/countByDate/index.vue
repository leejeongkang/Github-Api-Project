<template>
  <div>
    <h3>날짜별 커밋, 피알갯수</h3>
    <p>{{ repo }}</p>
    <p>{{ datePick }}</p>
    <p>커밋 : {{ $store.state.commitCntByDate }}</p>
    <p>피알 : {{ $store.state.prCntByDate }}</p>
  </div>
</template>

<script>

export default {
  name: "dateCount",
  props: {
    repo: {
      type: String
    },
    datePick: {
      type: String
    }
  }

}
</script>

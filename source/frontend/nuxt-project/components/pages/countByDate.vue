<template>
  <div>
    <h3>날짜별 커밋, 피알갯수</h3>
    <p>{{ repo }}</p>
    <p>{{ datePick }}</p>
    <p>커밋 : {{ commitCntByDate }}</p>
    <p>피알 : {{ prCntByDate }}</p>
  </div>
</template>

<script>

import {mapState} from "vuex";

export default {
  name: "dateCount",
  props: {
    repo: {
      type: String
    },
    datePick: {
      type: String
    }
  },
  computed: {
    ...mapState(['commitCntByDate', 'prCntByDate'])
  }

}
</script>

<template>
  <div>
    <table>
      <thead>
      <tr>
        <th>COMMIT</th>
        <th>PR</th>
        <th>USER</th>
        <th>BRANCH</th>
      </tr>
      </thead>
      <tbody>
      <tr>
        <td>{{ commitCnt.commitCount }}</td>
        <td>{{ prCnt }}</td>
        <td>{{ authorCnt }}</td>
        <td>{{ branchCnt }}</td>
      </tr>
      </tbody>
    </table>
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

<style scoped>
table{
  width: 75%;
  text-align : left;
}
table th{
  padding : 12px;
  border-bottom: 2px solid  darkgray;
}
table td{
  padding : 12px;
}
</style>

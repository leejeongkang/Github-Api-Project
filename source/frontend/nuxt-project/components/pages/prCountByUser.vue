<template>
  <div>
    <h2>pr count by user</h2>
    <table>
      <thead>
        <tr>
          <th>No</th>
          <th>id</th>
          <th>state</th>
          <th>date</th>
        </tr>
      </thead>
      <tbody>
      <tr v-for="pr in prCntByUser"
          :key="pr.number">
        <td>{{ pr.number }}</td>
        <td>{{ pr.id }}</td>
        <td>{{ pr.state }}</td>
        <td>{{ pr.created_at }}</td>

      </tr>
      </tbody>
    </table>

    <button>이전</button>
    <button @click="prevBtn({repo,page})">다음</button>
  </div>
</template>

<script>
import {mapState} from "vuex";

export default {
  name: 'prCountByUser',
  data() {
    return {
      page: 2
    }
  },
  props: {
    repo: ''
  },
  computed: {
    ...mapState(['prCntByUser'])
  },
  methods: {
    prevBtn({repo, page}) {
      this.$store.dispatch('getPrCntByUserPage', {repo, page})
      console.log('repo: ' + repo + 'page: ' + page)
    }
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
table tr:nth-of-type(even){
  background-color: rgba(0,0,255,0.1);
}
</style>

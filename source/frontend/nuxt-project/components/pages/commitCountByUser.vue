<template>
  <div>
    <h2>유저별 커밋정보</h2>
    <table>
      <thead>
      <tr>
        <th>Author</th>
        <th>Email</th>
        <th>Date</th>
        <th>Message</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="commit in commitCntByUser"
          :key="commit.sha">
        <td>{{ commit.commit.author.name }}</td>
        <td>{{ commit.commit.author.email }}</td>
        <td>{{ commit.commit.author.date }}</td>
        <td>{{ commit.commit.message }}</td>
      </tr>
      </tbody>
    </table>
    <ul>
      <li v-for="(data, index) in commitCnt.list"
          @click="pagination({repo, page: data})">
        {{ data }}
      </li>
    </ul>
    <p>전체 페이지: {{ commitCnt.totalPage }}</p>
    <p>첫 페이지: {{ commitCnt.beginPage }}</p>
    <p>마지막 페이지: {{ commitCnt.endPage }}</p>

    <button @click="prevBtn({repo,page})">이전</button>
    <button @click="nextBtn({repo,page})">다음</button>
  </div>
</template>
<script>
import {mapState} from "vuex";

export default {
  name: "userCount",
  props: {
    repo: '',
  },
  computed: {
    ...mapState(['commitCntByUser', 'commitCnt']),
  },
  methods: {
    pagination({ repo, page }) {
      console.log(page)
      this.$emit('update', page)
      this.$store.dispatch('getCommitCntByUserPage', { repo, page })

    },
    prevBtn({ repo, page }){
      page = this.$store.state.commitCnt.beginPage -1
      this.$store.dispatch('getCommitCntByUserPage', {repo, page})
    },
    nextBtn({ repo, page }) {
      page = this.$store.state.commitCnt.endPage + 1
      this.$store.dispatch('getCommitCntByUserPage', {repo, page})
      console.log('Prev: ' + repo + 'page: ' + page)
    },
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
  border-bottom: 2px solid darkgray;
}
table td{
  padding : 12px;
}
table tr:nth-of-type(even){
  background-color: rgba(0,0,255,0.1);
}
</style>

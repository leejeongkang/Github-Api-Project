<template>
  <div>
    <div class="repo">
      <repo-list @update="timeChanged"/>
    </div>
    <div class="branch">
      <branch-list :repo="repo"></branch-list>
    </div>
    <div class="main">
      <div class="detail-count">
        <count :repo="repo"></count>
      </div>
      <div class="date-count">
        <date-picker :repo="repo"></date-picker>
        <count-by-date :repo="repo" ></count-by-date>
      </div>
      <div class="user-count">
        <commit-count-by-user :repo="repo" @update="pageNum" />
        <pr-count-by-user :repo="repo" />
      </div>
    </div>
  </div>
</template>


<script>
import DatePicker from '@component/functional/datepicker/date-picker'

export default {
  name: "Index",
  components: { DatePicker,},
  data() {
    return{
      repo: '',
      page: ''
    }
  },
  methods: {
    timeChanged(repo) {
      this.repo = repo
    },
    pageNum(page) {
      console.log(page)
      this.page = page
    }
  }
};
</script>

<style lang="scss" scoped>
.repo {
  float: left;
  width: 13%;
  display: flex;
  justify-content: space-between;
  align-items: center;
  background: lightgray;
  padding: 8px 12px;
}
.branch {
  float: left;
  width: 13%;
  display: flex;
  justify-content: space-between;
  align-items: center;
  background:lightblue;
  padding: 8px 12px;
}
.main {
  display: flex;
  align-items: center;
  padding: 8px 12px;
  justify-content: space-between;
}
.detail-count {
  width: 800px;
  height: 100px;
}
.date-count {
  width: 1000px;
  height: 100px;
}
.user-count {
  width: 1200px;
  height: 100px;
}

</style>

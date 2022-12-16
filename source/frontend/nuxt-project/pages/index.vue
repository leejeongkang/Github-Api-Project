<template>
  <div>
    <div class="repo">
      <repo-list @update="timeChanged"/>
    </div>
    <div class="branch">
      <branch-list :repo="repo"></branch-list>
    </div>
    <div class="main">
      <detail-count :repo="repo"></detail-count>
      <date-picker :repo="repo" @update="dateUpdate"></date-picker>
      <date-count :repo="repo" :date-pick="datePick"></date-count>
      <highcharts />
    </div>
  </div>
</template>


<script>
import BranchList from "@component/pages/branchList";
import DetailCount from "@component/pages/count";
import DatePicker from '@component/functional/datepicker/date-picker'
import RepoList from "@component/pages/repoList";
import Highcharts from "@functional/highcharts/hightcharts";
import DateCount from "@component/pages/countByDate";
import {mapActions} from "vuex";

export default {
  name: "Index",
  components: {DateCount, Highcharts, BranchList, RepoList, DetailCount, DatePicker,},
  data() {
    return{
      repo: '',
      datePick: ''
    }
  },
  methods: {
    timeChanged(repo) {
      this.repo = repo
    },
    dateUpdate(dateValue) {
      this.datePick = dateValue
      console.log(this.datePick)
    },
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
  float: left;
  width: 73%
}

</style>

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
        <date-picker :repo="repo" @update="dateUpdate"></date-picker>
        <count-by-date :repo="repo"></count-by-date>
      </div>
      <div class="user-count">
        <highcharts />
        <count-by-user :repo="repo"></count-by-user>
      </div>
    </div>
  </div>
</template>


<script>
import DatePicker from '@component/functional/datepicker/date-picker'
import Highcharts from "@functional/highcharts/hightcharts";

export default {
  name: "Index",
  components: {Highcharts, DatePicker,},
  data() {
    return{
      repo: '',
      options: {
        title: {
          text: 'text high charts'
        },
        series: [{
          type: 'pie',
          name: '',
          innerSize: '45%',
          data: [
            ['1', 10.0],
            ['2', 20.0],
            ['3', 30.0],
            ['4', 40.0]
          ]
        }]
      }
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
  display: flex;
  align-items: center;
  padding: 8px 12px;
  justify-content: space-between;
}
.detail-count {
  width: 100px;
  height: 100px;
}
.date-count {
  width: 100px;
  height: 100px;
}
.user-count {
  width: 100px;
  height: 100px;
}

</style>

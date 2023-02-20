<template>
  <div>
    <h3>날짜별 커밋, 피알갯수</h3>
    <p>{{ repo }}</p>
    <!--
    <ul v-for="commit in commitCntByDate">
      <li>{{ commit.commit.author.date | formatDate }}</li>
    </ul>
    -->
    <button @click="dataSource">버튼</button>

    <ul v-for="commit in commitCntByDate">
      <li>{{ commit }}</li>
    </ul>
    <div v-show="dataSource">
      <hightcharts :options="options"/>
    </div>
  </div>
</template>

<script>

import {mapState} from "vuex";

export default {
  name: "dateCount",
  data() {
    return {
      options: {
        chart: {
          type: "line"
        },
        title: {
          text: "날짜별 commit 갯수!"
        },
        xAxis: {
          type: 'datetime',
          categories: []
        },
        series: {
          name: 'Commit',
          marker: {
            symbol: 'square'
          },
          data: []
        },
      }
    }
  },
  props: {
    repo: {
      type: String
    }
  },
  created() {
    return{
    }
  },
  computed: {
    ...mapState(['commitCntByDate', 'prCntByDate']),
    myKeys: Object.keys(this.commitCntByDate),
    myValues: Object.values(this.commitCntByDate)
    /*
    storeData: function() {
      const chart = this.chartData;
      //chart.xAxis.categories = Object.keys(this.commitCntByDate)
      //chart.series.data = Object.values(this.commitCntByDate)
      chart.xAxis.categories = ['2022-05-09', '2022-05-10']
      chart.series = [1,2]
      return chart;
    },
     */
  },
  watch: {},
  methods: {
    dataSource: function () {
      //const centuries = this.commitCntByDate.map(item => (item.commit.author.date))
      const myKeys = Object.keys(this.commitCntByDate)
      console.log(myKeys)
      const myValues = Object.values(this.commitCntByDate)
      console.log(myValues)
      return myValues
      // const centuries = this.commitCntByDate.map(item => (item.keys()))
      /*
            const base = _(centuries)
              .countBy()
              .map((value, key) => ({key, value}))
              .value()
            const categories = base.map(item => item.key)
            const values = base.map(item => item.value)
       */
    },
  }
}
</script>

<template>
  <div>
    <chart :options="options" />
  </div>
</template>

<script>
import { Chart } from "highcharts-vue";

export default {
  name: "Highcharts",
  components: {
    Chart
  },
  data() {
    return {
      /*options: {
        chart: {
          type: "spline"
        },
        title: {
          text: "날짜별 커밋 갯수"
        },
        xAxis: {
          categories: this.$store.state.commitCntByDate
        },
        series: [{
            data: [],
          }]
      }
    */
    };
  },
  watch: {},
  props: {
    options: {
      type: Object,
      default: () => {
        return {}
      },
    },
    computed: {},
    methods: {},
    mounted() {
    },
    created() {
    }
  }
}
</script>

<style lang="scss" scoped>
@import "highcharts";
</style>

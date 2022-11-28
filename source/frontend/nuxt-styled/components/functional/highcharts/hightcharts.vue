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
    };
  },
  watch: {},
  props: {
    options: {
      type: Object,
      default: () => {}
    }
  },
  computed: {},
  methods: {},
  mounted() {},
  created() {}
};
</script>

<style lang="scss" scoped>
@import "highcharts";
</style>

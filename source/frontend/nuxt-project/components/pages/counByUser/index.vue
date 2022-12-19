<template>
  <div>
    <h1>유저별 커밋정보</h1>
    <ul>
      <li v-for="commit in $store.state.commitCntByUser"
          :key="commit.sha">
        {{ commit.commit.author.name }}
        {{ commit.commit.author.date }}
      </li>
    </ul>
    <highcharts />
  </div>
</template>
<script>
import Highcharts from "@functional/highcharts/hightcharts";
export default {
  name: "userCount",
  components: {Highcharts},
  props: {
    repo: {
      type: String
    }
  }

}
</script>

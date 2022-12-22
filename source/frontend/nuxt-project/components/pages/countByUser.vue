<template>
  <div>
    <h1>유저별 커밋정보</h1>
    <ul>
      <li v-for="commit in commitCntByUser"
          :key="commit.sha">
        {{ commit.commit.author.name }}
        {{ commit.commit.author.date }}
      </li>
    </ul>
    <h1>유저별 피알정보</h1>
    <ul>
      <li v-for="pr in prCntByUser"
          :key="pr.number">
        <p>number: {{ pr.number }}</p>
        <p> created: {{ pr.created_at}}</p>
        <p>user: {{ pr.user }}</p>
        <p>id: {{ pr.id }}</p>
      </li>
    </ul>
  </div>
</template>
<script>
import {mapState} from "vuex";

export default {
  name: "userCount",
  computed: {
    ...mapState(['commitCntByUser', 'prCntByUser'])
  }

}
</script>

<template lang="html">
  <div class="card-wrap">
    <ul>
      <group-card></group-card>
      <group-card></group-card>
      <group-card></group-card>
      <group-card></group-card>
      <group-card></group-card>
      <group-card></group-card>
      <group-card></group-card>
    </ul>
  </div>
</template>

<script type="text/javascript">
import GroupCard from "@molecules/group-card/group-card.vue";
export default {
  name: "ListCard",
  components: { GroupCard }
};
</script>

<style lang="scss" scoped>
@import "./list-card.scss";
</style>

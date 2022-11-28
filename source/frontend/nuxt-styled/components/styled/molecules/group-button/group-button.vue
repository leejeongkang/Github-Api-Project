<template lang="html">
  <div class="button-group">
    <base-button class="button--danger button--lg button--left">
      <span class="button__text"> 취소 </span>
    </base-button>
    <base-button class="button--tertiary button--lg">
      <span class="button__text"> 닫기 </span>
    </base-button>
    <base-button class="button--primary button--lg">
      <span class="button__text"> 적용 </span>
    </base-button>
    <base-button class="button--danger button--lg button--right">
      <span class="button__text"> 목록 </span>
    </base-button>
  </div>
</template>

<script type="text/javascript">
import BaseButton from "@atoms/base-button/base-button.vue";

export default {
  name: "GroupButton",
  components: {
    BaseButton
  }
};
</script>

<style lang="scss" scoped>
@import "./group-button.scss";
</style>

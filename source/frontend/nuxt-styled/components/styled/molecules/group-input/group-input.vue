<template lang="html">
  <div class="form__detail-item" :class="inputesClass">
    <div class="text-input-group" :class="inputClass">
      <base-input class="text-input text-input--lg"></base-input>
    </div>
    <div class="text-input-group" :class="inputClass">
      <base-input class="text-input text-input--lg"></base-input>
    </div>
  </div>
</template>

<script type="text/javascript">
import BaseInput from "@atoms/base-input/base-input.vue";

export default {
  name: "GroupInput",
  props: {
    checkboxId1: {
      type: String,
      default: null
    },
    checkboxId2: {
      type: String,
      default: null
    },
    name: {
      type: String,
      default: null
    },
    inputesClass: {
      type: String
    },
    inputClass: {
      type: String
    }
  },
  components: {
    BaseInput
  }
};
</script>

<style lang="scss" scoped>
@import "./group-input.scss";
</style>

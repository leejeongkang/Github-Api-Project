<template lang="html">
  <div class="radios" :class="radiosClass">
    <!--    질문 - checked / disabled 와 같이 각각 따로 설정해줘야 하는 속성은 radioId1 처럼 각각 props를 만들어 줘야만 하는지? -->
    <base-radio :name="name" :radioId="radioId1" :class="radioClass">
      <template v-slot:label>
        <slot name="label1">Radio-1</slot>
      </template>
    </base-radio>
    <base-radio :name="name" :radioId="radioId2" :class="radioClass">
      <template v-slot:label>
        <slot name="label2">Radio-2</slot>
      </template>
    </base-radio>
  </div>
</template>

<script type="text/javascript">
import BaseRadio from "@atoms/base-radio/base-radio.vue";

export default {
  name: "GroupRadio",
  props: {
    radioId1: {
      type: String,
      default: null
    },
    radioId2: {
      type: String,
      default: null
    },
    name: {
      type: String,
      default: null
    },
    radiosClass: {
      type: String
    },
    radioClass: {
      type: String
    }
  },
  components: {
    BaseRadio
  }
};
</script>

<style lang="scss" scoped>
@import "./group-radio.scss";
</style>

<template lang="html">
  <div class="checkboxes" :class="checkboxesClass">
    <!--    질문 - checked / disabled 와 같이 각각 따로 설정해줘야 하는 속성은 checkboxId1 처럼 각각 props를 만들어 줘야만 하는지? -->
    <base-checkbox :name="name" :checkboxId="checkboxId1" :class="checkboxClass">
      <template v-slot:label>
        <slot name="label1">Checkbox-1</slot>
      </template>
    </base-checkbox>
    <base-checkbox :name="name" :checkboxId="checkboxId2" :class="checkboxClass">
      <template v-slot:label>
        <slot name="label2">Checkbox-2</slot>
      </template>
    </base-checkbox>
  </div>
</template>

<script type="text/javascript">
import BaseCheckbox from "@atoms/base-checkbox/base-checkbox.vue";

export default {
  name: "GroupCheckbox",
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
    checkboxesClass: {
      type: String
    },
    checkboxClass: {
      type: String
    }
  },
  components: {
    BaseCheckbox
  }
};
</script>

<style lang="scss" scoped>
@import "./group-checkbox.scss";
</style>

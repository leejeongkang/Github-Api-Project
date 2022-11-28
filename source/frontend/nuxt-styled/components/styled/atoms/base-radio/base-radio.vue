<template>
  <div class="radio">
    <input type="radio" class="radio__input" :id="radioId" :name="name" :checked="checked" :disabled="disabled" />
    <label class="radio__label" :for="radioId">
      <slot name="label" class="radio__label">Default Label</slot>
    </label>
  </div>
</template>

<script>
export default {
  name: "BaseRadio",
  props: {
    disabled: {
      type: Boolean,
      default: false
    },
    radioId: {
      type: String,
      default: null
    },
    name: {
      type: String,
      default: null
    },
    checked: {
      type: Boolean,
      default: false
    }
  },
  computed: {},
  methods: {}
};
</script>

<style lang="scss">
@import "base-radio.scss";
</style>

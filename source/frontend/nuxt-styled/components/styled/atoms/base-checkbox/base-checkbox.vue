<template>
  <div class="checkbox">
    <input type="checkbox" class="checkbox__input" :id="checkboxId" :name="name" :checked="checked" :disabled="disabled" />
    <label class="checkbox__label" :for="checkboxId">
      <slot name="label" class="checkbox__label">Default Label</slot>
    </label>
  </div>
</template>

<script>
export default {
  name: "BaseCheckbox",
  props: {
    disabled: {
      type: Boolean,
      default: false
    },
    checkboxId: {
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
@import "base-checkbox";
</style>

<template>
  <!-- type="submit" 인 경우, id가 필요 -->
  <button class="button" type="submit" :id="submitId" v-if="submitId">
    <slot></slot>
  </button>
  <!-- 그 외 타입은 id 불필요 -->
  <button class="button" type="button" @click="handleClick($event)" @mousedown="mouseDown($event)" v-else>
    <slot></slot>
  </button>
</template>

<script>
export default {
  name: "BaseButton",
  props: {
    submitId: {
      type: String,
      default: null
    }
  },
  computed: {},
  methods: {
    handleClick($event) {
      this.$emit("click", $event);
    },
    mouseDown($event) {
      this.$emit("mousedown", $event);
    }
  }
};
</script>

<style lang="scss">
@import "base-button.scss";
</style>

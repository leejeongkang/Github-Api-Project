<template>
  <!--  최소 단위인 tag Component - 기능 별로 쪼개는 작업 필요-->
  <button type="button" class="tag">
    <slot></slot>
  </button>
</template>

<script>
export default {
  name: "BaseTag",
  props: {},
  computed: {},
  methods: {}
};
</script>

<style scoped></style>

<template lang="html">
  <input type="text" class="text-input" @input="$emit('input', $event.target.value)" @keydown="$emit('keydown', $event)" />
</template>

<script type="text/javascript">
export default {
  name: "BaseInput",
  extends: {},
  props: {},
  data() {
    return {
      data: null
    };
  },
  computed: {},
  components: {},
  watch: {},
  methods: {},
  beforeCreate() {},
  mounted() {}
};
</script>

<style lang="scss">
@import "base-input";
</style>

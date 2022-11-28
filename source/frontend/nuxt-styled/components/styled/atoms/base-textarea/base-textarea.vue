<template lang="html">
  <textarea type="text" class="text-area" @input="$emit('input', $event.target.value)" @keydown="$emit('keydown', $event)"></textarea>
</template>

<script type="text/javascript">
export default {
  name: "BaseTextarea",
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
@import "base-textarea";
</style>

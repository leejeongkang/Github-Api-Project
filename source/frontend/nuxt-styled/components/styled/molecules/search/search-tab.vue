<template lang="html">
  <div>
    <button type="button" class="tab__button" role="tab" aria-selected="false" @click="onClick">
      <span class="tab__button-text">{{ title }}</span>
    </button>
  </div>
</template>

<script type="text/javascript">
export default {
  name: "SearchTab",
  props: {
    title: {
      type: String,
      default: "전체"
    },
    type: {
      type: String
    }
  },
  methods: {
    onClick() {
      this.$emit("tab-select", this.type);
    }
  }
};
</script>

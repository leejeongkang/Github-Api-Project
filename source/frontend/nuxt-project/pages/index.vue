<template>
  <div>
    <div class="cover">
      <h1 class="title--color">{{ $t("index.hello") }}</h1>
    </div>
  </div>
</template>

<i18n src="./index.json"></i18n>

<script>
export default {
  name: "Index",
  async asyncData({ store }) {
    await store.dispatch("getCsrfToken");
  },
  mounted() {
    sessionStorage.clear();
  }
};
</script>

<style lang="scss" scoped>
@import "index";
</style>

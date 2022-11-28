<template>
  <modal name="loader-modal" class="loading-page" :height="96" :width="96">
    <!--   Loader 커스터마이징 클래스 -> loader--purple -->
    <div class="loader loader--purple" role="alert" aria-live="assertive">
      <div class="loader__spinner"></div>
    </div>
  </modal>
</template>

<script>
export default {
  name: "Loader",
  data() {
    return {
      count: 0
    };
  },
  methods: {
    start() {
      console.log("LOADER START - " + this.count);
      if (this.count == 0) {
        this.$modal.show("loader-modal");
      }
      this.count++;
    },
    finish() {
      this.count--;
      if (this.count > 0) {
        return;
      }
      setTimeout(() => {
        this.$modal.hide("loader-modal");
        this.count = 0;
        console.log("LOADER HIDE- " + this.count);
      }, 1000);
    }
  }
};
</script>

<style lang="scss">
@import "./loader.scss";
</style>

<template lang="html">
  <modal
    :width="width"
    :height="height"
    :name="dialogName"
    :draggable="true"
    :clickToClose="false"
    @opened="onOpen"
    @closed="scrollHandler(false)"
  >
    <div class="modal">
      <div class="modal__head">
        <div class="modal__head-title">
          <span class="modal__head-title-text">
            {{ title }}
          </span>
        </div>
        <div class="modal__head-close-button">
          <button class="button button--link button--icon" @click="onClose">
            <svg-icon name="close" class="svg-icon"></svg-icon>
          </button>
        </div>
      </div>

      <slot name="body" class="modal__body" />

      <slot name="foot">
        <div class="modal__foot">
          <div class="modal__foot-main-buttons">
            <button class="button button--tertiary button--lg" @click="onClose">
              <span class="button__text"> {{ $t("dialog.cancel") }} </span>
            </button>
            <button class="button button--secondary button--lg" @click="onConfirm">
              <span class="button__text"> {{ $t("dialog.confirm") }} </span>
            </button>
          </div>
        </div>
      </slot>
    </div>
  </modal>
</template>

<i18n src="./dialog.json"></i18n>

<script type="text/javascript">
export default {
  name: "Dialog",
  props: {
    title: {
      type: String
    },
    height: {
      type: String,
      default: "100%"
    },
    width: {
      type: String,
      default: "100%"
    },
    dialogName: {
      type: String,
      required: true
    },
    opened: {
      type: Boolean,
      default: false
    }
  },
  mounted() {
    if (this.opened) {
      this.$modal.show(this.dialogName);
    }
  },
  methods: {
    onClose() {
      this.scrollHandler(false);
      this.$modal.hide(this.dialogName);
      this.$emit("close", this.dialogName);
    },
    onConfirm() {
      this.scrollHandler(false);
      this.$emit("confirm", this.dialogName);
    },
    onOpen() {
      this.scrollHandler();
      this.$emit("open", this.dialogName);
    },
    scrollHandler(open = true) {
      const className = "not-scroll";
      let $html = document.querySelector("html");
      if ($html) {
        if (open) $html.classList.add(className);
        else $html.classList.remove(className);
      }
      let $body = document.querySelector("body");
      if ($body) {
        if (open) $body.classList.add(className);
        else $body.classList.remove(className);
      }
    }
  }
};
</script>

<style lang="scss" scoped>
@import "dialog.scss";
</style>

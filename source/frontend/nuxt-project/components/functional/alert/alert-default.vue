<template lang="html">
  <div class="alert alert--default" :class="alertIconTheme" :style="{ width: width + 'px', height }">
    <div class="alert__body">
      <div class="alert__close-button">
        <button class="button button--link button--xl" @click="onClose">
          <svg-icon name="close" class="svg-icon"></svg-icon>
        </button>
      </div>
      <svg-icon name="info-fill" class="alert__icon svg-icon" />
      <div class="alert__contents">
        <p class="alert__title">{{ title }}</p>
        <p class="alert__text" v-html="content" />
      </div>
    </div>
    <div class="alert__foot">
      <div class="alert__foot-main-buttons">
        <button
          class="button button--tertiary button--lg"
          :class="alertCancelButtonTheme"
          v-if="type === 'confirm'"
          @click.stop="onCancel"
        >
          {{ cancelButtonText }}
        </button>
        <button class="button button--secondary button--lg" :class="alertConfirmButtonTheme" @click.stop="onConfirm">
          {{ confirmButtonText }}
        </button>
      </div>
    </div>
  </div>
</template>

<i18n src="./alert-default.json"></i18n>

<script type="text/javascript">
export default {
  name: "AlertDefault",
  props: {
    width: {
      type: String,
      default: "100%"
    },
    height: {
      type: String,
      default: "auto"
    },
    title: {
      type: String
    },
    content: {
      type: String
    },
    iconTheme: {
      type: String,
      default: "info"
    },
    cancelButtonTheme: {
      type: String,
      default: function () {
        return this.$t("alert.property.cancel-button-theme");
      }
    },
    confirmButtonTheme: {
      type: String,
      default: function () {
        return this.$t("alert.property.confirm-button-theme");
      }
    },
    confirmButtonText: {
      type: String,
      default: function () {
        return this.$t("alert.confirm");
      }
    },
    cancelButtonText: {
      type: String,
      default: function () {
        return this.$t("alert.cancel");
      }
    },
    type: {
      type: String,
      default: "default"
    }
  },
  computed: {
    alertIconTheme: function () {
      return "alert--" + this.iconTheme;
    },
    alertCancelButtonTheme: function () {
      return "button--" + this.cancelButtonTheme;
    },
    alertConfirmButtonTheme: function () {
      return "button--" + this.confirmButtonTheme;
    }
  },
  methods: {
    onCancel() {
      this.$parent.$emit("cancel");
      this.$emit("close");
    },
    onConfirm() {
      this.$parent.$emit("confirm");
      this.$emit("close");
    },
    onClose() {
      this.$emit("close");
    }
  }
};
</script>

<style lang="scss" scoped>
@import "alert-default";
</style>

<template lang="html">
  <!--  아이콘을 사용하지 않는 경우, alert--default 사용 -->
  <div class="alert" :class="alertIconTheme" :style="{ width, height }">
    <!--    TODO: [개발-질문] dialog와 같이 slot으로 설정할 수 없나요? -> 스토리북에서 실행이 안돼서 확인을 못함 -->
    <div class="alert__body">
      <!--
      위 alertIconTheme에 맞춰서 아이콘도 변경돼야 함
      alert--info -> info-fill
      alert--warning -> warning-fill
      alert--success -> checkmark-fill
      alert--error -> issue-fill
      -->
      <svg-icon name="info-fill" class="alert__icon svg-icon"/>
      <div class="alert__contents">
        <p class="alert__text">{{ alertText }}</p>
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
      default: "100%"
    },
    alertText: {
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

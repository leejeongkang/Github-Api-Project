<template lang="html">
  <div>
    <select class="login_form-locale" v-model="locale" @change="onChangeLocale">
      <option value="ko">한국어</option>
      <option value="en">English</option>
    </select>
  </div>
</template>

<script type="text/javascript">
export default {
  name: "Locale",
  data() {
    return {
      locale: "ko"
    };
  },
  mounted() {
    this.locale = this.$i18n.locale;
  },
  methods: {
    onChangeLocale() {
      /**
       * 변경된 로케일 코드를 반환
       *
       * @event changeLocale
       * @property {string} locale - 로케일코드
       */
      this.$emit("changeLocale", this.locale);
    }
  }
};
</script>

<style lang="scss">
@import "locale";
</style>

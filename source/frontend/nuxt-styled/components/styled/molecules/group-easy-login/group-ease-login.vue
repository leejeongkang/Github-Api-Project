<template lang="html">
  <div class="easy-login">
    <strong class="easy-login__title">간편 로그인 안내</strong>
    <p class="easy-login__description">추가 항목 입력을 통해 SNS 계정으로 서비스 이용이 가능합니다.</p>
    <ul class="easy-login__list">
      <li class="easy-login__item">
        <base-button class="button--lg button--tertiary easy-login__button" title="카카오 로그인">
          <img class="button__image" src="~@/assets/style-product/images/common/share_kakao.png" alt="kakao" />
          <span class="button__text">카카오 로그인</span>
        </base-button>
      </li>
      <li class="easy-login__item">
        <base-button class="button--lg button--tertiary easy-login__button" title="네이버 로그인">
          <img class="button__image" src="~@/assets/style-product/images/common/share_cafe.png" alt="naver" />
          <span class="button__text">네이버 로그인</span>
        </base-button>
      </li>
      <li class="easy-login__item">
        <base-button class="button--lg button--tertiary easy-login__button" title="구글 로그인">
          <img class="button__image" src="~@/assets/style-product/images/common/share_kakao.png" alt="google" />
          <span class="button__text">구글 로그인</span>
        </base-button>
      </li>
    </ul>
    <p class="easy-login__description">* 간편 로그인 사용자는 소셜 서비스에서 가입정보를 찾아 주시기 바랍니다.</p>
  </div>
</template>
<script type="text/javascript">
import BaseButton from "@component/styled/atoms/base-button/base-button";

export default {
  name: "GroupEasyLogin",
  extends: {},
  props: {},
  data() {
    return {};
  },
  computed: {},
  components: { BaseButton },
  watch: {},
  methods: {}
};
</script>

<style lang="scss" scoped>
@import "group-ease-login";
</style>

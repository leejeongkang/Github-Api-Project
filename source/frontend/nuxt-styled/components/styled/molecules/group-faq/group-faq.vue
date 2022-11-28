<template lang="html">
  <table class="faq" :class="themeClass">
    <caption class="hidden">@@@@ 게시판입니다.</caption>
    <colgroup class="pc-only">
      <col style="width:80px">
      <col style="width:100px">
      <col>
    </colgroup>
    <colgroup class="mobile-colgroup">
      <col style="width:50px">
      <col>
      <col style="width: 0">
    </colgroup>
    <thead>
    <tr>
      <th scope="col">번호</th>
      <th scope="col">구분</th>
      <th scope="col">제목</th>
    </tr>
    </thead>
    <tbody>
    <tr class="faq__item" :class="isPreview ? 'faq__item--oepn' : ''" @click="contentPreview">
      <td class="mobile-show">Q</td>
      <td>데이터</td>
      <td class="mobile-show text-left">
        <span class="faq__item-qus">회원가입은 어떻게 하나요?</span>
        <!-- 새글 아이콘 -->
        <BaseBadge class="badge--sm badge--teal"><span class="badge__label">NEW</span></BaseBadge>
      </td>
    </tr>
    <tr class="faq__item-content">
      <td class="mobile-show">A</td>
      <td class="mobile-show text-left" colspan="2">
        <span class="faq__item-ans">휴대폰 본인인증 진행 후 회원가입이 가능합니다.</span>
      </td>
    </tr>
    </tbody>
  </table>
</template>

<script type="text/javascript">
import BaseBadge from "@component/styled/atoms/base-badge/base-badge";

export default {
  name: "GroupFaq",
  props: {
    themeClass: {
      type: String
    },
    mobileClass: {
      type: String
    }
  },
  data() {
    return {
      isPreview: false
    };
  },
  methods: {
    contentPreview: function () {
      this.isPreview = !this.isPreview;
    }
  },
  components: {
    BaseBadge
  }
};
</script>

<style lang="scss" scoped>
@import "components/styled/molecules/group-faq/group-faq";
</style>

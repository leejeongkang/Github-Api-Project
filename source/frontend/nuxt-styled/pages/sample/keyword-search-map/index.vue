<template lang="html">
  <div class="contents-wrap">
    <h2 class="hidden">검색 데이터 상세</h2>
    <div class="contents-top">
      <div class="contents-top__breadcrumb">
        <group-breadcrumb></group-breadcrumb>
      </div>
      <div class="subject">
        <div class="subject__wrap">
          <div class="subject__title-wrap">
            <h3 class="subject__title">데이터 맵 검색</h3>
            <p class="subject__desc">데이터의 위치를 한눈에 검색할 수 있도록 시각화 된 데이터 맵을 제공합니다.</p>
          </div>
        </div>
      </div>
      <div class="contents-top__search">
        <group-search></group-search>
      </div>
    </div>
    <div class="contents">
      <div class="contents__inner">
        <div class="contents__temp"></div>
      </div>
    </div>
  </div>
</template>
<script type="text/javascript">
import BaseRadio from "@component/styled/atoms/base-radio/base-radio";
import BaseTag from "@component/styled/atoms/base-tag/base-tag";
import BaseButton from "@component/styled/atoms/base-button/base-button";
import BaseBadge from "@component/styled/atoms/base-badge/base-badge";
import BaseCheckbox from "@component/styled/atoms/base-checkbox/base-checkbox";
import GroupBreadcrumb from "@component/styled/molecules/group-breadcrumb/group-breadcrumb";
import GroupSearch from "@component/styled/molecules/group-search/group-search";

import { mapGetters } from "vuex";

export default {
  name: "Index",
  layout: "sample/sample",
  async asyncData({ store }) {
    await store.dispatch("sample/keyword-search/getContents");
  },
  computed: {
    ...mapGetters({
      contents: "sample/keyword-search/contents"
    })
  },
  data() {
    return {
      tableLow: [
        { title1: "제공기관(데이터 제공처)", content1: "도로교통공사", title2: "관리부서", content2: "데이터융합처" },
        { title1: "담당자", content1: "홍길동", title2: "관리부서 전화번호", content2: "033-749-5266" }
      ],

      tableLow2: [
        { title1: "카테고리 (분류체계)", content1: "자동차제조>스마트팩토리", title2: "라이선스", content2: "국토교통부43개" },
        { title1: "데이터 유형", content1: "데이터셋", title2: "사용언어", content2: "한국어" },
        { title1: "카테고리 (분류체계)", content1: "자동차제조>스마트팩토리", title2: "라이선스", content2: "국토교통부43개" },
        { title1: "데이터 유형", content1: "데이터셋", title2: "사용언어", content2: "한국어" },
        { title1: "카테고리 (분류체계)", content1: "자동차제조>스마트팩토리", title2: "라이선스", content2: "국토교통부43개" },
        { title1: "데이터 유형", content1: "데이터셋", title2: "사용언어", content2: "한국어" }
      ]
    };
  },
  components: {
    BaseRadio,
    BaseButton,
    BaseBadge,
    BaseTag,
    BaseCheckbox,
    GroupSearch,
    GroupBreadcrumb
  }
};
</script>

<style lang="scss" scoped>
@import "./index.scss";
</style>

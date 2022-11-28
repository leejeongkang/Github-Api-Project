<template lang="html">
  <!--  검색 결과 Template-->
  <div class="search-result">
    <div class="section-head">
      <h4>페이지 타이틀<span>(<strong>152</strong>)건</span></h4>
      <div class="section-head__options">
        <div class="radios radios--toggle">
          <base-radio name="radio-test-icon" radioId="radio2" class="radio--icon">
            <template v-slot:label>
              <svg-icon name="app-switcher" class="svg-icon"/><span class="hidden">목록형</span>
            </template>
          </base-radio>
          <base-radio name="radio-test-icon" radioId="radio2" class="radio--icon">
            <template v-slot:label>
              <svg-icon name="menu" class="svg-icon"/><span class="hidden">카드형</span>
            </template>
          </base-radio>
        </div>
      </div>
    </div>
<!--   카드형인 경우, data-box-list--card 클래스 추가-->
    <search-list :list="contents" :class="listClass"></search-list>
  </div>
</template>

<script type="text/javascript">
import BaseRadio from "@component/styled/atoms/base-radio/base-radio"
import SearchList from "@organisms/search-list/search-list.vue";
import { mapGetters } from "vuex";
export default {
  name: "SearchResult",
  layout: "sample",
  extends: {},
  props: {
    listClass: {
      type: String
    },
    foo: {},
    fooBar: {}
  },
  computed: {
    ...mapGetters({
      contents: "sample/search/contents"
    })
  },
  components: { SearchList, BaseRadio },
  watch: {},
  methods: {}
};
</script>

<style lang="scss" scoped>
@import "search-result.scss";
</style>

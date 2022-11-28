<template lang="html">
  <div class="ui-template">
    <!-- pagination -->
    <div class="pagination pc-only">
      <base-button class="button--link pagination__button">
        <svg-icon class="svg-icon" name="chevron-double-left-medium" aria-hidden="true"></svg-icon>
        <span class="hidden">맨 처음으로 이동</span>
      </base-button>
      <base-button class="button--link pagination__button">
        <svg-icon class="svg-icon" name="chevron-left-medium" aria-hidden="true"></svg-icon>
        <span class="hidden">이전 페이지로 이동</span>
      </base-button>
      <ul class="pagination__list">
        <li class="pagination__item" v-for="(item, index) in numList">
          <a class="pagination__link" href="#none" :key="index" :class="item === 1 ? 'pagination__link--selected' : ''">{{ item }}</a>
        </li>
      </ul>
      <base-button class="button--link pagination__button">
        <svg-icon class="svg-icon" name="chevron-right-medium" aria-hidden="true"></svg-icon>
        <span class="hidden">다음 페이지로 이동</span>
      </base-button>
      <base-button class="button--link pagination__button">
        <svg-icon class="svg-icon" name="chevron-double-right-medium" aria-hidden="true"></svg-icon>
        <span class="hidden">맨 마지막으로 이동</span>
      </base-button>
    </div>

    <div class="pagination-more mobile-only">
      <button type="button" class="pagination-more__button pagination-more__button--bg-none" title="해당내용 더보기">
        <span class="pagination-more__paging"
          >더보기
          <span class="hidden">현재</span>
          <em class="pagination-more__text-accent">1</em>
          <span class="pagination-more__total-num">/<span class="hidden">전체</span>13</span></span
        >
        <svg-icon class="svg-icon pagination-more__icon" name="chevron-down" aria-hidden="true"></svg-icon>
      </button>
    </div>
  </div>
</template>
<script type="text/javascript">
import { mapGetters } from "vuex";
import BaseButton from "@atoms/base-button/base-button.vue";

export default {
  name: "GroupPagination",
  extends: {},
  props: {
    bar: {},
    foo: {},
    fooBar: {}
  },
  data() {
    return {
      numList: 10
    };
  },
  computed: {
    ...mapGetters({
      contents: "sample/search/contents"
    })
  },
  components: { BaseButton },
  watch: {},
  methods: {}
};
</script>

<style lang="scss" scoped>
@import "./group-pagination.scss";
</style>

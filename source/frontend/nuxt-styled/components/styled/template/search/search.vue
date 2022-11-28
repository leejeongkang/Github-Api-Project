<template lang="html">
  <div class="search-results">
    <strong class="search-results__text">
      검색어<em class="text-emphasis color-emphasis">'키워드'</em>에 대한 총
      <em class="text-emphasis">1,265,082건</em>
      의 검색 결과를 찾았습니다.
    </strong>
    <div class="search-results__tab tab tab--container tab--horizontal">
      <ul class="tab__bar" role="tablist">
        <li v-for="(item, index) in tabs" :key="search" :class="item.selected ? 'tab__item--selected' : ''" class="tab__item">
          <SearchTab :title="item.title" :type="item.type" @tab-select="onTabSelect" />
        </li>
      </ul>
    </div>

    <div class="search-results__content">
      <div class="article">
        <div class="article__topic">
          <strong class="article__topic-title"> {{ selectedTab.title }} </strong>
          <span class="article__topic-text"> ({{ selectedTab.count }}) </span>
          <div class="article__controller">
            <button class="button button--link" type="button">
              <span class="button__text">정확도순</span>
            </button>
            <span class="division-line" aria-hidden="true"></span>
            <button class="button button--link" type="button">
              <span class="button__text">최신순</span>
            </button>
          </div>
          <div class="article__controller">
            <button class="button button--tertiary" type="button">
              <svg-icon class="svg-icon" name="refresh.svg"></svg-icon>
              <span class="button__text">새로고침</span>
            </button>
            <button class="button button--support" type="button">
              <svg-icon class="svg-icon" name="dual-axis.svg"></svg-icon>
              <span class="button__text">평판분석</span>
            </button>
            <div class="select" :class="isSelectOpen ? 'select--open' : ''" @click="isSelectOpen = !isSelectOpen" role="select" aria-expanded="false">
              <div class="select-selector">
                <button class="select-selector__button" type="button" title="보기 방식 선택">
                  <span class="select-selector__title">10개씩 보기</span>
                  <svg-icon class="svg-icon select-selector__icon" name="chevron-down-medium.svg"></svg-icon>
                </button>
              </div>
              <div class="select-container">
                <ul class="select-container__list">
                  <li class="select-container__item">
                    <button class="select-container__button" type="button" role="option">
                      <span class="select-container__text">Sample Select</span>
                    </button>
                  </li>
                  <li class="select-container__item">
                    <button class="select-container__button" type="button" role="option">
                      <span class="select-container__text">Sample Select</span>
                    </button>
                  </li>
                  <li class="select-container__item">
                    <button class="select-container__button" type="button" role="option">
                      <span class="select-container__text">Sample Select</span>
                    </button>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>
        <search-result-article :list="contents"></search-result-article>
        <div class="article__view-more">
          <button class="button button--underline" type="button">
            <span class="button__text">더보기</span>
            <svg-icon class="svg-icon" name="next.svg"></svg-icon>
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<i18n src="./search.json"></i18n>

<script type="text/javascript">
import SearchResultArticle from "@organisms/search/search-result-article.vue";
import SearchTab from "@molecules/search/search-tab.vue";

import { mapGetters, mapMutations, mapActions } from "vuex";

export default {
  name: "SearchResult",
  layout: "sample",
  data() {
    return {
      isSelectOpen: false
    };
  },
  computed: {
    ...mapGetters({
      tabs: "sample/search/tabs",
      contents: "sample/search/contents",
      selectedTab: "sample/search/selectedTab"
    })
  },
  components: {
    SearchResultArticle,
    SearchTab
  },
  // async fetch ({ store, params }) {
  //   await store.dispatch("sample/search/getTabs");
  //   await store.dispatch("sample/search/getContents");
  // },
  async mounted() {
    await this.$store.dispatch("sample/search/getTabs");
    await this.$store.dispatch("sample/search/getContents");
  },
  methods: {
    ...mapMutations({
      setSelectedTab: "sample/search/setSelectedTab"
    }),

    onTabSelect(key) {
      this.setSelectedTab(key);
    }
  }
};
</script>

<style lang="scss">
@import "search";
</style>

<template lang="html">
  <div class="text-input-group text-input-group--lg">
    <label for="inp-search-lg-01" class="hidden">Label</label>
    <base-input @keydown="isComboBoxShow = true" id="inp-search-lg-01" placeholder="placeholder text" ></base-input>
    <base-button class="text-input-group__clear-button" title="초기화">
      <svg-icon class="svg-icon" name="close" aria-hidden="true"></svg-icon>
    </base-button>
    <base-button title="검색" class="text-input-group__search-button button--icon button--lg button--tertiary">
      <svg-icon class="svg-icon button__icon" name="search" aria-hidden="true"></svg-icon>
    </base-button>
<!--    콤보박스 오픈 시 combo-box--open 추가-->
    <div class="combo-box" :class="isComboBoxShow ? 'combo-box--open': ''" >
      <div class="combo-box__title">
        <p>최근 검색어</p>
        <base-button class="button--sm button--link">
          <span class="button__text">전체삭제</span>
        </base-button>
      </div>
      <!--      최근 검색어-->
      <div class="recent-search">
        <ul class="recent-search__list">
          <li class="recent-search__item" v-for="item in searchList" :key="item.num">
            <div class="keyword">
              <a class="keyword__link" href="#none">{{ item.title }}</a>
              <base-button class="keyword__button button--link button--sm button--icon" title="삭제">
                <svg-icon class="svg-icon" name="close" aria-hidden="true"></svg-icon>
              </base-button>
            </div>
          </li>
        </ul>
      </div>
      <!--      자동완성 -->
      <ul class="autocomplete">
        <li class="autocomplete__item" value="1">
          <a href="" class="autocomplete__link" target="_blank" title="바로검색하기"><strong class="autocomplete__title">스</strong></a>
        </li>
        <li class="autocomplete__item" value="1">
          <a href="" class="autocomplete__link" target="_blank" title="바로검색하기"><strong class="autocomplete__title">스</strong>마트</a>
        </li>
        <li class="autocomplete__item" value="1">
          <a href="" class="autocomplete__link" target="_blank" title="바로검색하기"><strong class="autocomplete__title">스</strong>마트팜</a>
        </li>
        <li class="autocomplete__item" value="1">
          <a href="" class="autocomplete__link" target="_blank" title="바로검색하기">아<strong class="autocomplete__title">스</strong>파라거<strong class="autocomplete__title">스</strong></a>
        </li>
      </ul>
    </div>
  </div>
</template>

<script type="text/javascript">
import BaseButton from "@component/styled/atoms/base-button/base-button.vue";
import BaseInput from "@component/styled/atoms/base-input/base-input";
import BaseTag from "@component/styled/atoms/base-tag/base-tag";

export default {
  name: "GroupSearch",
  props:{
  },
  components: {
    BaseTag,
    BaseInput,
    BaseButton
  },
  data() {
    return {
      isComboBoxShow: false,
      searchList: [
        { num: 0, title: "계절별 교통 증가" },
        { num: 1, title: "결빙" },
        { num: 2, title: "다발지역" },
        { num: 3, title: "날씨" },
        { num: 4, title: "국도교통부" },
        { num: 5, title: "계절별 교통 증가" },
        { num: 6, title: "결빙" },
        { num: 7, title: "다발지역" },
        { num: 8, title: "날씨" },
        { num: 9, title: "국도교통부" }
      ]
    };
  }
};
</script>

<style lang="scss" scoped>
@import "./group-search.scss";
</style>

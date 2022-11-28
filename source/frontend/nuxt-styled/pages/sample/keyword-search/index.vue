<template lang="html">
  <div class="contents-wrap">
    <h2 class="hidden">데이터 검색</h2>
    <div class="contents-top">
      <div class="contents-top__breadcrumb">
        <group-breadcrumb></group-breadcrumb>
      </div>
      <div class="subject">
        <div class="subject__wrap">
          <div class="subject__title-wrap">
            <h3 class="subject__title">데이터 검색</h3>
            <p class="subject__desc">데이터를 트리구조로 검색할 수 있는 트리뷰를 제공합니다.</p>
          </div>
        </div>
      </div>
      <div class="contents-top__search">
        <search-input-field></search-input-field>
        <div class="contents-top__recommend">
          추천 검색어
          <div class="tags">
            <base-tag class="tag--cyan-deep">
              <span class="tag__label">#결빙</span>
            </base-tag>
            <base-tag class="tag--red">
              <span class="tag__label">#사고</span>
            </base-tag>
            <base-tag class="tag--purple">
              <span class="tag__label">#다발지역</span>
            </base-tag>
            <base-tag class="tag--cyan-deep">
              <span class="tag__label">#교통</span>
            </base-tag>
            <base-tag class="tag--red">
              <span class="tag__label">#날씨</span>
            </base-tag>
            <base-tag class="tag--purple">
              <span class="tag__label">#다발지역</span>
            </base-tag>
          </div>
        </div>
      </div>
      <div class="contents-search-result">
        <p class="contents-search-result__text">
          <mark>"keyword"</mark>
          검색결과, 총 <strong>150</strong>건 입니다.
        </p>
      </div>
      <div class="contents-top__detail-filter">
        <div class="detail-filter">
          <base-button class="detail-filter__toggle-button button--link">
            <span class="button__text">상세필터보기</span>
            <svg-icon name="chevron-down-medium" class="svg-icon" />
            <span class="hidden">열기</span>
          </base-button>
          <div class="detail-filter__group">
            <strong class="detail-filter__title">카테고리</strong>
            <div class="detail-filter__checkboxes">
              <base-checkbox name="filter-check" checkboxId="1" class="checkbox--toggle checkbox--sm">
                <template v-slot:label> 자동차 부품</template>
              </base-checkbox>
              <base-checkbox name="filter-check" checkboxId="2" class="checkbox--toggle checkbox--sm">
                <template v-slot:label> 자동차 제조</template>
              </base-checkbox>
              <base-checkbox name="filter-check" checkboxId="3" class="checkbox--toggle checkbox--sm">
                <template v-slot:label> 화물운송 서비스</template>
              </base-checkbox>
              <base-checkbox name="filter-check" checkboxId="5" class="checkbox--toggle checkbox--sm">
                <template v-slot:label> 관련서비스 산업</template>
              </base-checkbox>
              <base-checkbox name="filter-check" checkboxId="6" class="checkbox--toggle checkbox--sm">
                <template v-slot:label> 자동차 제조</template>
              </base-checkbox>
              <base-checkbox name="filter-check" checkboxId="7" class="checkbox--toggle checkbox--sm">
                <template v-slot:label> 화물운송 서비스</template>
              </base-checkbox>
              <base-checkbox name="filter-check" checkboxId="8" class="checkbox--toggle checkbox--sm">
                <template v-slot:label> 관련서비스 산업</template>
              </base-checkbox>
            </div>
          </div>
          <div class="detail-filter__group">
            <strong class="detail-filter__title">제공기관</strong>
            <div class="detail-filter__checkboxes">
              <base-checkbox name="filter-check-02" checkboxId="1" class="checkbox--toggle checkbox--sm">
                <template v-slot:label> 국도교통부</template>
              </base-checkbox>
              <base-checkbox name="filter-check-02" checkboxId="2" class="checkbox--toggle checkbox--sm">
                <template v-slot:label> 한자연</template>
              </base-checkbox>
              <base-checkbox name="filter-check-02" checkboxId="3" class="checkbox--toggle checkbox--sm">
                <template v-slot:label> 농림축산식품</template>
              </base-checkbox>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="contents">
      <div class="contents__sort">
        <div class="contents__aside">
          <div class="contents__aside-head">
            <base-checkbox class="contents__aside-checkbox" name="allCheck1" checkbox-id="all-check-1">
              <template v-slot:label> 전체 </template>
            </base-checkbox>
            <strong class="contents__aside-title"> 카테고리 </strong>
            <div class="contents__aside-options">
              <base-button class="button--icon button--link button--sm">
                <svg-icon class="svg-icon" name="chevron-down.svg"></svg-icon>
              </base-button>
            </div>
          </div>
          <div class="contents__aside-body">
            <div class="contents-filter">
              <div class="search-filter">
                <div class="search-filter__head">
                  <base-checkbox name="searchFilterAll" checkbox-id="searchFilterAll1">
                    <template v-slot:label> 자동차 부품 </template>
                  </base-checkbox>
                </div>
                <div class="search-filter__body">
                  <ul class="search-filter__list">
                    <li class="search-filter__item">
                      <div class="search-filter__item-group">
                        <base-checkbox name="searchFilter2" checkbox-id="check-1">
                          <template v-slot:label> 샤시 </template>
                        </base-checkbox>
                      </div>
                    </li>
                    <li class="search-filter__item">
                      <div class="search-filter__item-group">
                        <base-checkbox name="searchFilter2" checkbox-id="check-1">
                          <template v-slot:label> 구동계 </template>
                        </base-checkbox>
                      </div>
                    </li>
                  </ul>
                </div>
              </div>
              <div class="search-filter">
                <div class="search-filter__head">
                  <base-checkbox name="searchFilterAll" checkbox-id="searchFilterAll1">
                    <template v-slot:label> 관제 / 사고 </template>
                  </base-checkbox>
                </div>
                <div class="search-filter__body">
                  <ul class="search-filter__list">
                    <li class="search-filter__item">
                      <div class="search-filter__item-group">
                        <base-checkbox name="searchFilter" checkbox-id="check-1">
                          <template v-slot:label> 관련 서비스 산업 </template>
                        </base-checkbox>
                      </div>
                    </li>
                    <li class="search-filter__item">
                      <div class="search-filter__item-group">
                        <base-checkbox name="searchFilter" checkbox-id="check-1">
                          <template v-slot:label> 자율주행차 </template>
                        </base-checkbox>
                      </div>
                    </li>
                  </ul>
                </div>
              </div>
              <div class="contents-filter__reset-button">
                <base-button class="button--danger button--sm">
                  <svg-icon class="svg-icon" name="reset.svg"></svg-icon>
                  <span class="button__text">초기화</span>
                </base-button>
              </div>
            </div>
            <div class="contents-filter">
              <div class="accordion">
                <div class="accordion__item">
                  <button class="accordion__head accordion__head--open" aria-expanded="true" aria-controls="accordion-01">
                    <span class="accordion__head-title"> 데이터 타입 </span>
                  </button>
                  <div class="accordion__body" id="accordion-01">
                    <div class="accordion-vertical">
                      <ul class="accordion-vertical__list">
                        <li class="accordion-vertical__item">
                          <button class="accordion-vertical__button">
                            <span class="accordion-vertical__text"> 데이터셋(파일) </span>
                          </button>
                        </li>
                        <li class="accordion-vertical__item">
                          <button class="accordion-vertical__button">
                            <span class="accordion-vertical__text"> 링크 </span>
                          </button>
                        </li>
                      </ul>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="contents-filter">
              <div class="accordion">
                <div class="accordion__item">
                  <button class="accordion__head accordion__head--open" aria-expanded="true" aria-controls="accordion-01">
                    <span class="accordion__head-title"> 데이터 제공기관 </span>
                    <svg-icon class="accordion__head-icon svg-icon" name="chevron-left-medium.svg"></svg-icon>
                  </button>
                  <div class="accordion__body" id="accordion-02">
                    <div class="accordion-vertical">
                      <ul class="accordion-vertical__list">
                        <li class="accordion-vertical__item accordion-vertical__item--selected">
                          <button class="accordion-vertical__button">
                            <span class="accordion-vertical__text"> 도로교통공단 </span>
                          </button>
                        </li>
                        <li class="accordion-vertical__item">
                          <button class="accordion-vertical__button">
                            <span class="accordion-vertical__text"> 한국지질자원연구원 </span>
                          </button>
                        </li>
                        <li class="accordion-vertical__item">
                          <button class="accordion-vertical__button">
                            <span class="accordion-vertical__text"> 제공기관명 </span>
                          </button>
                        </li>
                      </ul>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="contents__result">
          <div class="contents__tab">
            <group-tab></group-tab>
          </div>
          <div class="contents__list">
            <!--  검색 결과 Template-->
            <div class="contents__list-inner">
              <div class="section-head">
                <h4>페이지 타이틀<span>(<strong>152</strong>)건</span></h4>
                <div class="section-head__options">
                  <div class="radios radios--toggle">
                    <base-radio name="radio-test-icon" radioId="radio1" class="radio--icon">
                      <template v-slot:label>
                        <svg-icon name="app-switcher" class="svg-icon" />
                        <span class="hidden">목록형</span></template
                      >
                    </base-radio>
                    <base-radio name="radio-test-icon" radioId="radio2" class="radio--icon">
                      <template v-slot:label>
                        <svg-icon name="menu" class="svg-icon" />
                        <span class="hidden">카드형</span></template
                      >
                    </base-radio>
                  </div>
                </div>
              </div>
              <!--   카드형인 경우, data-box-list--card 클래스 추가-->
              <search-list :list="contents"></search-list>
            </div>
          </div>
          <div class="contents__pagination">
            <group-pagination></group-pagination>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script type="text/javascript">
import BaseRadio from "@component/styled/atoms/base-radio/base-radio";
import BaseTag from "@component/styled/atoms/base-tag/base-tag";
import BaseButton from "@component/styled/atoms/base-button/base-button";
import BaseCheckbox from "@component/styled/atoms/base-checkbox/base-checkbox";
import GroupTab from "@component/styled/molecules/group-tab/group-tab";
import GroupPagination from "@component/styled/molecules/group-pagination/group-pagination";
import GroupBreadcrumb from "@component/styled/molecules/group-breadcrumb/group-breadcrumb";
import SearchList from "@organisms/search-list/search-list.vue";
import SearchInputField from "@organisms/search-input-field/search-input-field.vue";
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
  components: {
    BaseRadio,
    BaseButton,
    BaseTag,
    BaseCheckbox,
    GroupPagination,
    GroupBreadcrumb,
    GroupTab,
    SearchList,
    SearchInputField
  }
};
</script>

<style lang="scss" scoped>
@import "./index.scss";
</style>

<template lang="html">
  <!--  검색 리스트 - 리스트형 / 카드형 -->
  <!--  카드형 - data-box-list--card-->
  <ul class="data-box-list">
    <li class="data-box" v-for="(item, index) in list" :key="index">
      <a href="#" class="data-box__link">
        <!--          <div class="data-box__visual">-->
        <!--            <svg-icon class="svg-icon" name="map-shape" aria-hidden="true"></svg-icon>-->
        <!--            <span class="data-box__label">도로교통공단</span>-->
        <!--          </div>-->
        <div class="data-box__information">
          <div class="data-box__top-content">
            <div class="badges">
              <base-badge class="badge--green">
                <span class="badge__label">내부</span>
              </base-badge>
              <base-badge class="badge--red">
              <span class="badge__label">자동차 부품</span>
            </base-badge>
            </div>
            <div class="company-group">
              <svg-icon class="svg-icon company-group__icon" name="global" aria-hidden="true"></svg-icon>
              <span class="company-group__text">도로교통공단</span>
            </div>
            <div class="data-options">
              <div class="badge"><span class="badge__label">CSV</span></div>
              <div class="badge"><span class="badge__label">XNK</span></div>
              <base-button class="button--icon button--link button--sm data-options__tooltip">
                <svg-icon class="svg-icon data-options__icon" name="share" aria-hidden="true"></svg-icon>
                <div class="tooltip-studio tooltip-studio--light tooltip-studio--bottom-right" role="tooltip"
                     style="display: none">
                  <span class="tooltip-studio__arrow"></span>
                  <div class="tooltip-studio__inner">
                    <div class="h-group">
                      <base-button class="button button--link button--icon" title="트위터로 공유하기">
                        <svg-icon class="svg-icon company-group__icon" name="global" aria-hidden="true"></svg-icon>
                      </base-button>
                      <base-button class="button button--link button--icon" title="트위터로 공유하기">
                        <svg-icon class="svg-icon company-group__icon" name="global" aria-hidden="true"></svg-icon>
                      </base-button>
                    </div>
                  </div>
                </div>
              </base-button>
              <base-button class="button--icon button--link button--sm data-options__tooltip">
                <svg-icon class="svg-icon data-options__icon" name="bookmark" aria-hidden="true"></svg-icon>
                <div class="tooltip-studio tooltip-studio--light tooltip-studio--bottom-right" role="tooltip"
                     style="display: none">
                  <span class="tooltip-studio__arrow"></span>
                  <div class="tooltip-studio__inner">
                    <span class="tooltip-studio__text">관심데이터 추가</span>
                  </div>
                </div>
              </base-button>
            </div>
          </div>
          <div class="data-box__content">
            <strong class="data-box__title"
            >
              {{ item.title }}도로교통공단_
              <mark>결빙사고</mark>
              다발지역 최대두줄 최대두줄 될수 있어요 두줄이 넘어가면 어떻게 되나요
            </strong>
            <p class="data-box__description">
              노면 상태가 서리/
              <mark>결빙</mark>
              인 교통사고에 대한
              <mark>사고</mark>
              다발 지역 정보노면 상태가 서리/
              <mark>결빙</mark>
              인 교통사고에 대한
              <mark>사고</mark>
              다발 지역 정보노면 상태가 서리/
              <mark>결빙</mark>
              인 교통사고에 대한
              <mark>사고</mark>
              다발 지역 정보노면 상태가 서리/
              <mark>결빙</mark>
              인 교통사고에 대한
              <mark>사고</mark>
              다발 지역 정보노면 상태가 서리/
              <mark>결빙</mark>
              인 교통사고에 대한
              <mark>사고</mark>
              다발 지역 정보노면 상태가 서리/
              <mark>결빙</mark>
              인 교통사고에 대한
              <mark>사고</mark>
              다발 지역 정보노면 상태가 서리/
              <mark>결빙</mark>
              인 교통사고에 대한
              <mark>사고</mark>
              다발 지역 정보노면 상태가 서리/
              <mark>결빙</mark>
              인 교통사고에 대한
              <mark>사고</mark>
              다발 지역 정보노면 상태가 서리/
              <mark>결빙</mark>
              인 교통사고에 대한
              <mark>사고</mark>
              다발 지역 정보노면 상태가 서리/
              <mark>결빙</mark>
              인 교통사고에 대한
              <mark>사고</mark>
              다발 지역 정보노면 상태가 서리/
              <mark>결빙</mark>
              인 교통사고에 대한
              <mark>사고</mark>
              다발 지역 정보노면 상태가 서리/
              <mark>결빙</mark>
              인 교통사고에 대한
              <mark>사고</mark>
              다발 지역 정보노면 상태가 서리/
              <mark>결빙</mark>
              인 교통사고에 대한
              <mark>사고</mark>
              다발 지역 정보노면 상태가 서리/
              <mark>결빙</mark>
              인 교통사고에 대한
              <mark>사고</mark>
              다발 지역 정보
            </p>
          </div>
          <div class="data-box__bottom-content">
            <div class="data-box__keyword">
              <dl>
                <dt class="hidden">
                  키워드
                </dt>
                <dd>
                  <div class="tags">
                    <base-tag class="tag--cyan">
                      <span class="tag__label">#결빙</span>
                    </base-tag>
                    <base-tag class="tag--red">
                      <span class="tag__label">#사고</span>
                    </base-tag>
                    <base-tag class="tag--green">
                      <span class="tag__label">#다발지역</span>
                    </base-tag>
                  </div>
                </dd>
              </dl>
            </div>
            <div class="data-box__details">
              <div class="data-box__details-group">
                <dl>
                  <dt>
                    수정일
                  </dt>
                  <dd>2021-08-20</dd>
                </dl>
                <dl>
                  <dt>
                    등록일
                  </dt>
                  <dd>2021-08-20</dd>
                </dl>
                <dl class="dl--hidden">
                  <dt>
                    키워드
                  </dt>
                  <dd>
                    <div class="tags">
                      <base-tag class="tag--cyan">
                        <span class="tag__label">#결빙</span>
                      </base-tag>
                      <base-tag class="tag--red">
                        <span class="tag__label">#사고</span>
                      </base-tag>
                      <base-tag class="tag--green">
                        <span class="tag__label">#다발지역</span>
                      </base-tag>
                    </div>
                  </dd>
                </dl>
              </div>
              <div class="data-box__details-group">
                <dl>
                  <dt>
                    <svg-icon class="svg-icon" name="download" aria-hidden="true"></svg-icon>
                    <span class="hidden">다운로드 수</span>
                  </dt>
                  <dd>1,500</dd>
                  <dt>
                    <svg-icon class="svg-icon" name="eye" aria-hidden="true"></svg-icon>
                    <span class="hidden">조회수</span>
                  </dt>
                  <dd>1,500</dd>
                </dl>
              </div>
            </div>
          </div>
        </div>
      </a>
    </li>
  </ul>
</template>

<script type="text/javascript">
import BaseBadge from "@atoms/base-badge/base-badge.vue";
import BaseButton from "@atoms/base-button/base-button.vue";
import BaseTag from "@atoms/base-tag/base-tag.vue";

export default {
  name: "SearchList",
  extends: {},
  props: {
    list: {
      type: Array,
      default: function () {
        return [];
      }
    }
  },

  computed: {
    contents: function () {
      return this.list;
    }
  },
  components: {BaseBadge, BaseButton, BaseTag},
  watch: {},
  methods: {}
};
</script>

<style lang="scss">
@import "./search-list";
</style>

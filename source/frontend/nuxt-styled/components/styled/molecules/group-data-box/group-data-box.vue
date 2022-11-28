<template lang="html">
  <li class="data-box">
    <a href="#" class="data-box__link">
      <div class="data-box__visual">
        <svg-icon class="svg-icon" name="bookmark" aria-hidden="true"></svg-icon>
        <span class="data-box__label">도로교통공단</span>
      </div>
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
          <group-share></group-share>
        </div>
        <div class="data-box__content">
          <strong class="data-box__title"
          >
            도로교통공단_
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
          <div class="data-box__details">
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
        </div>
      </div>
    </a>
  </li>
</template>

<script type="text/javascript">
import BaseBadge from "@atoms/base-badge/base-badge.vue";
import BaseTag from "@atoms/base-tag/base-tag.vue";
import BaseButton from "@atoms/base-button/base-button.vue";
import GroupShare from "@molecules/group-share/group-share.vue";

export default {
  name: "GroupDataBox",
  props: {
  },
  components: {
    BaseBadge,
    BaseTag,
    BaseButton,
    GroupShare
  }
};
</script>

<style lang="scss" scoped>
@import "./group-data-box";
</style>

<template lang="html">
  <li class="card-group">
    <a href="#none">
      <div class="card-group__badge">
        <base-badge class="badge--purple-deep">
          <span class="badge__label"> badge </span>
        </base-badge>
        <em>데이터 타입</em>
      </div>
      <div class="card-group__image">이미지</div>
      <div class="card-group__data">
        <strong class="card-group__title"
        >card-group__title Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet assumenda consectetur eligendi
          facere, fugiat itaque laborum maiores nemo quasi quibusdam ratione
          reprehenderit sapiente tempora velit voluptate. Architecto dolor eos error, et libero obcaecati temporibus
          ullam. Aliquid ratione sint voluptate voluptatibus?</strong
        >
        <p class="card-group__desc">
          card-group__desc Lorem ipsum dolor sit amet, consectetur adipisicing elit. A accusantium aperiam asperiores
          aspernatur assumenda commodi consequuntur corporis debitis deleniti deserunt dicta
          doloribus, est fuga fugiat harum id in libero minus nam necessitatibus nemo nobis nulla officiis perspiciatis
          quaerat quis reiciendis repellendus repudiandae sapiente similique sit suscipit
          temporibus vel vero voluptatibus!
        </p>
        <div class="data-info">
          <dl>
            <dt>등록일</dt>
            <dd>2021-08-20</dd>
          </dl>
        </div>
      </div>
    </a>
    <div class="card-group__service">
      <base-badge class="badge--cyan badge--sm">
        <span class="badge__label"> card-label </span>
      </base-badge>
      <a href="#none" class="service-link"
      >해당내용 링크타입은 길어질수도 있습니다 해당페이지로 바로가기입니다. Lorem ipsum dolor sit amet, consectetur adipisicing elit. At consequatur
        eligendi eveniet illum labore non qui recusandae
        sint ut voluptates. Lorem ipsum dolor sit amet, consectetur adipisicing elit. At corporis, delectus earum
        eligendi enim hic necessitatibus neque placeat reiciendis voluptate!
        <svg-icon class="svg-icon service-link__icon" name="chevron-right-medium.svg"></svg-icon>
      </a>
    </div>
  </li>
</template>

<script type="text/javascript">
import BaseBadge from "@component/styled/atoms/base-badge/base-badge";

export default {
  name: "GroupCard",
  components: {BaseBadge}
};
</script>

<style lang="scss" scoped>
@import "./group-card.scss";
</style>

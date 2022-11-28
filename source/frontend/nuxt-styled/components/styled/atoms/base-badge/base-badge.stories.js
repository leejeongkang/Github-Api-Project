import BaseBadge from "./base-badge.vue";
import StoriesContainer from "@component/stories-container";

export default {
  title: 'Styled/Atoms/[PCFC] 뱃지',
  components: BaseBadge,
  decorators: [
    () => ({
      template:
        '<div style="margin: 1em;"><h2 style="margin-bottom: 20px; font-size: 20px; color: #212121;">(예시) Badge Element </h2><div style="display: flex; flex-direction: row; "><story /></div></div>',
    }),
  ],
};

export const Default = () => ({
  components: { StoriesContainer, BaseBadge },
  template:
    "<StoriesContainer>" +
    '<BaseBadge class="badge--lg badge--green-deep"><span class="badge__label">Badge - Large</span> </BaseBadge><br/>' +
    '<BaseBadge class="badge--lg badge--green-deep badge--icon"><fa :icon="[\'fas\', \'key\']" class="svg-icon badge__icon"/></BaseBadge><br/>' +
    '<BaseBadge class="badge--teal"><span class="badge__label">Badge - Default</span></BaseBadge><br/>' +
    '<BaseBadge  class="badge--icon badge--teal"><fa :icon="[\'fas\', \'key\']" class="svg-icon badge__icon"/></BaseBadge><br/>' +
    '<BaseBadge class="badge--sm badge--red"><span class="badge__label">Badge - small</span> </BaseBadge><br/>' +
    '<BaseBadge class="badge--sm badge--red badge--icon"><fa :icon="[\'fas\', \'key\']" class="svg-icon badge__icon"/></BaseBadge><br/>' +
    "</StoriesContainer>",
});

export const BadgeVertical = () => ({
  components: { StoriesContainer, BaseBadge },
  template:
    "<StoriesContainer>" +
    '<BaseBadge class="badge--lg badge--vertical"><svg-icon class="svg-icon radio__icon" name="menu" aria-hidden="true"></svg-icon><span class="badge__label">Badge - Large</span> </BaseBadge><br/>' +
    '<BaseBadge class="badge--vertical"><svg-icon class="svg-icon radio__icon" name="menu" aria-hidden="true"></svg-icon><span class="badge__label">Badge</span> </BaseBadge><br/><br/>' +
    '<BaseBadge class="badge--sm badge--vertical"><svg-icon class="svg-icon radio__icon" name="menu" aria-hidden="true"></svg-icon><span class="badge__label">Badge - Small</span> </BaseBadge><br/><br/>' +
    "</StoriesContainer>",
});


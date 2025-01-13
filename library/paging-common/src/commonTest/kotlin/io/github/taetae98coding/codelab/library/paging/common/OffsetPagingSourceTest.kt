package io.github.taetae98coding.codelab.library.paging.common

import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import androidx.paging.testing.TestPager
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe

class OffsetPagingSourceTest : BehaviorSpec() {
    init {
        Given("pageSize=30, initialLoadSize=30, totalCount=70") {
            val pager = TestPager(
                config = PagingConfig(
                    pageSize = 30,
                    initialLoadSize = 30,
                ),
                pagingSource = FakeOffsetPagingSource(70),
            )

            When("Refresh with null") {
                val page = pager.refresh() as PagingSource.LoadResult.Page

                Then("data should have size 30") {
                    page.data shouldHaveSize 30
                }

                Then("prevKey should be null") {
                    page.prevKey.shouldBeNull()
                }

                Then("nextKey should be 30") {
                    page.nextKey shouldBe 30
                }

                Then("itemsBefore should be 0") {
                    page.itemsBefore shouldBe 0
                }

                Then("itemsAfter should be 70") {
                    page.itemsAfter shouldBe 40
                }
            }

            And("Prepend") {
                val page = pager.prepend()

                Then("page should be null") {
                    page.shouldBeNull()
                }
            }

            And("Append (1)") {
                val page = pager.append() as PagingSource.LoadResult.Page

                Then("data should have size 30") {
                    page.data shouldHaveSize 30
                }

                Then("prevKey should be 0") {
                    page.prevKey shouldBe 30
                }

                Then("nextKey should be 60") {
                    page.nextKey shouldBe 60
                }

                Then("itemsBefore should be 30") {
                    page.itemsBefore shouldBe 30
                }

                Then("itemsAfter should be 40") {
                    page.itemsAfter shouldBe 10
                }
            }

            And("Append (2)") {
                val page = pager.append() as PagingSource.LoadResult.Page

                Then("data should have size 10") {
                    page.data shouldHaveSize 10
                }

                Then("prevKey should be 60") {
                    page.prevKey shouldBe 60
                }

                Then("nextKey should be null") {
                    page.nextKey.shouldBeNull()
                }

                Then("itemsBefore should be 60") {
                    page.itemsBefore shouldBe 60
                }

                Then("itemsAfter should be 0") {
                    page.itemsAfter shouldBe 0
                }
            }

            And("Append (3)") {
                val page = pager.append()

                Then("page should be null") {
                    page.shouldBeNull()
                }
            }
        }

        Given("pageSize=30, initialLoadSize=90, totalCount=100") {
            val pager = TestPager(
                config = PagingConfig(
                    pageSize = 30,
                    initialLoadSize = 90,
                ),
                pagingSource = FakeOffsetPagingSource(100),
            )

            When("Refresh with null") {
                val page = pager.refresh() as PagingSource.LoadResult.Page

                Then("data should have size 90") {
                    page.data shouldHaveSize 90
                }

                Then("prevKey should be null") {
                    page.prevKey.shouldBeNull()
                }

                Then("nextKey should be 90") {
                    page.nextKey shouldBe 90
                }

                Then("itemsBefore should be 0") {
                    page.itemsBefore shouldBe 0
                }

                Then("itemsAfter should be 10") {
                    page.itemsAfter shouldBe 10
                }
            }

            And("Prepend") {
                val page = pager.prepend()

                Then("page should be null") {
                    page.shouldBeNull()
                }
            }

            And("Append (1)") {
                val page = pager.append() as PagingSource.LoadResult.Page

                Then("data should have size 10") {
                    page.data shouldHaveSize 10
                }

                Then("prevKey should be 90") {
                    page.prevKey shouldBe 90
                }

                Then("nextKey should be null") {
                    page.nextKey.shouldBeNull()
                }

                Then("itemsBefore should be 90") {
                    page.itemsBefore shouldBe 90
                }

                Then("itemsAfter should be 0") {
                    page.itemsAfter shouldBe 0
                }
            }

            And("Append (2)") {
                val page = pager.append()

                Then("page should be null") {
                    page.shouldBeNull()
                }
            }
        }

        Given("pageSize=30, initialLoadSize=90, totalCount=170") {
            val pager = TestPager(
                config = PagingConfig(
                    pageSize = 30,
                    initialLoadSize = 90,
                ),
                pagingSource = FakeOffsetPagingSource(170),
            )

            When("Refresh with 40") {
                val page = pager.refresh(40) as PagingSource.LoadResult.Page

                Then("data should have size 90") {
                    page.data shouldHaveSize 90
                }

                Then("prevKey should be 40") {
                    page.prevKey shouldBe 40
                }

                Then("nextKey should be 130") {
                    page.nextKey shouldBe 130
                }

                Then("itemsBefore should be 40") {
                    page.itemsBefore shouldBe 40
                }

                Then("itemsAfter should be 40") {
                    page.itemsAfter shouldBe 40
                }
            }

            And("Prepend (1)") {
                val page = pager.prepend() as PagingSource.LoadResult.Page

                Then("data should have size 30") {
                    page.data shouldHaveSize 30
                }

                Then("prevKey should be 10") {
                    page.prevKey shouldBe 10
                }

                Then("nextKey should be 40") {
                    page.nextKey shouldBe 40
                }

                Then("itemsBefore should be 10") {
                    page.itemsBefore shouldBe 10
                }

                Then("itemsAfter should be 130") {
                    page.itemsAfter shouldBe 130
                }
            }

            And("Prepend (2)") {
                val page = pager.prepend() as PagingSource.LoadResult.Page

                Then("data should have size 10") {
                    page.data shouldHaveSize 10
                }

                Then("prevKey should be null") {
                    page.prevKey.shouldBeNull()
                }

                Then("nextKey should be 10") {
                    page.nextKey shouldBe 10
                }

                Then("itemsBefore should be 0") {
                    page.itemsBefore shouldBe 0
                }

                Then("itemsAfter should be 160") {
                    page.itemsAfter shouldBe 160
                }
            }

            And("Prepend (3)") {
                val page = pager.prepend()

                Then("data should be null") {
                    page.shouldBeNull()
                }
            }

            And("Append (1)") {
                val page = pager.append() as PagingSource.LoadResult.Page

                Then("data should have size 30") {
                    page.data shouldHaveSize 30
                }

                Then("prevKey should be 130") {
                    page.prevKey shouldBe 130
                }

                Then("nextKey should be 160") {
                    page.nextKey shouldBe 160
                }

                Then("itemsBefore should be 130") {
                    page.itemsBefore shouldBe 130
                }

                Then("itemsAfter should be 10") {
                    page.itemsAfter shouldBe 10
                }
            }

            And("Append (2)") {
                val page = pager.append() as PagingSource.LoadResult.Page

                Then("data should have size 10") {
                    page.data shouldHaveSize 10
                }

                Then("prevKey should be 160") {
                    page.prevKey shouldBe 160
                }

                Then("nextKey should be null") {
                    page.nextKey.shouldBeNull()
                }

                Then("itemsBefore should be 160") {
                    page.itemsBefore shouldBe 160
                }

                Then("itemsAfter should be 0") {
                    page.itemsAfter shouldBe 0
                }
            }

            And("Append (3)") {
                val page = pager.append()

                Then("page should be null") {
                    page.shouldBeNull()
                }
            }
        }
    }
}
